import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private http:HttpClient) { }

  uploadImage(file)
  {
    return this.http.post("http://localhost:8080/YouFrame/uploadimage",file);
  }
  viewallimage()
  {
    return this.http.get("http://localhost:8080/YouFrame/viewimage");
  }
}
