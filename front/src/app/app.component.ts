import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CatalogueService} from "./service/catalogue.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  @ViewChild('mapSen', {static: false}) mapSen: ElementRef;
  title = 'SEN-DOCTOR';
  specialities;

  constructor(private  routeActive: ActivatedRoute, private route: Router, private catalogService:CatalogueService) {
  }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    let map = this.mapSen.nativeElement.querySelector("div");
    let paths = map.querySelectorAll('svg a');
    let links = map.querySelector('#map_list').querySelectorAll('a');


    //polyfill du foreach
    if (NodeList.prototype.forEach === undefined) {
      NodeList.prototype.forEach = function (callback) {
        [].forEach.call(this.callback)
      }
    }

    paths.forEach(path => {
      path.addEventListener("mouseenter", function (e) {
        let id = this.id;
        extracted(id);
      })
    });
    links.forEach(link => {
      link.addEventListener("mouseenter", function () {
        let id = this.id.replace("list-", "");
        extracted(id);

      })
    });
    map.addEventListener("mouseover", function (e) {
      let id;
      extracted(id);

    });

    function extracted(id) {
      map.querySelectorAll('.is-active').forEach(e => {
        e.classList.remove('is-active')

      });
      if (id != undefined) {
        map.querySelector('#map_list ' + '#list-' + id).classList.add('is-active');
        map.querySelector('svg #' + id).classList.add('is-active');
      }
    }

  }

  getUsersByville(event) {
    var data = {paysName: "senegal", ville: event.target.innerHTML};
    console.log(data, "tests mapp>>>>")
  }

  onClick($event) {
    var data = {
      paysName: "senegal",
      ville: $event.target.id
    };
    console.log(data, "on tests mapp>>>>")

  }

  getProfesionnalsByTown(formData) {
    this.catalogService.getProfesionnalsByTown(formData).subscribe(resp => {
        this.specialities = resp;
        console.log(this.specialities, "respose professionals");
        this.route.navigate(["/proffesionallist"])
      }, error => {
        console.log("this is error", error);
      }
    )
  }
}
