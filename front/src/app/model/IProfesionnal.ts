import IAdresse from "./IAdresse";
import IRoles from "./IRoles";
import IUserClientComment from "./IUserClientComment";
import IFormation from "./IFormation";
import ISpeciality from "./ISpeciality";

export default interface IProfesionnal {
  id: number,
  firstName:string,
  lastName:string,
  nameWithDeterminant:string
  nameWithTitle:string,
  photoName:string,
  adresse:IAdresse;
  description:string,
  password:string;
  email:string;
  confirmPassword:string;
  roles:IRoles;
  userClientComments:IUserClientComment;
  formations:IFormation;
  speciality:ISpeciality;

}
