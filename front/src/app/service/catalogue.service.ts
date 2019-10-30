import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {
  //public host = "http://5.51.141.181:8989";
  public host = "http://localhost:8080";
  private jwtToken: string;
  //public host = "http://192.168.1.90:8989";
  roles: Array<any>;
  filter: string;
  userName: string;

  constructor(private http: HttpClient,private router: Router) { }



  login(value) {
    return this.http.post(this.host + "/signin", value, {
      observe: 'response',
      headers: {'Content-Type': 'application/json'}
    })
  }

  saveToken(jwtToken: string) {
    localStorage.setItem("token", jwtToken);
    this.jwtToken = jwtToken;
    this.parsJWT();

  }

  parsJWT() {
    let jwtHelper = new JwtHelperService();
    let decodeToken = jwtHelper.decodeToken(this.jwtToken);
    this.userName = decodeToken.sub;
    this.roles = decodeToken.roles;
  }

  isAdmin() {
    return this.roles.find(p => {
      return this.isAuthentificated() &&  p == "ADMINISTRATOR"
    });
  }

  isUser() {
    return this.roles.find(p => {
      return this.isAuthentificated() &&  p == "USER"
    });
  }

  loadToken() {
    this.jwtToken = localStorage.getItem("token");
    this.parsJWT();
  }

  isAuthentificated() {
    return this.roles;
  }

  logout() {
    localStorage.removeItem("token");
    this.initParam();
    this.router.navigateByUrl("/login");
  }

  initParam() {
    this.userName = undefined;
    this.roles = undefined;
    this.jwtToken = undefined;
  }

  register(user: any) {
    return this.http.post(this.host + "/register", user);
  }

}
