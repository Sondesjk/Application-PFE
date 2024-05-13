import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './models/User.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private apiUrl = "http://localhost:8080/user/"
  constructor(private httpClient:HttpClient) { }
  login(username:String,password:String):  Observable<User>
  {
    const loginUrl=this.apiUrl+"login?username="+username+"&password="+password;
    return this.httpClient.get<User>(loginUrl)
  } 
  getAllUsers():Observable<User[]>{
    return this.httpClient.get<User[]>(this.apiUrl+"getAllUsers")
  }
  addUser(user:User){
    return this.httpClient.post<User>(this.apiUrl+"add",user)
  }
  deleteUser(id:number) :Observable<User>
  {
    return this.httpClient.delete<User>(this.apiUrl+"deleteuser/"+id)
  }
  updateVoiture(id:number,user:User):Observable<User>
  {
    return this.httpClient.put<User>(this.apiUrl+"updateUser/"+id, user)
  }
  getUserById(id:number):Observable<User>
  {
    return this.httpClient.get<User>(this.apiUrl+"getUserById/"+id)
  }
}

