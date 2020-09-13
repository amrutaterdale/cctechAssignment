import { Component, OnInit } from '@angular/core';
import { UploadService } from '../upload.service';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {

  constructor(private ser:UploadService) { }
  no=1;
allimage:any=[];
model:any={};
selectedFile=null;
  ngOnInit() {
    this.ser.viewallimage().subscribe(d=>this.allimage=d);
    // console.log(this.allimage);
  }

  retreive()
  {
    this.ser.viewallimage().subscribe((d:any)=>this.allimage=d);
  }

  onFileSelected(file:FileList)
  {
this.selectedFile=file.item(0);
var reader=new FileReader();
reader.onload=(event:any)=>
{
  this.model.img=event.target.result;
  console.log(this.model.img);
  
  this.ser.uploadImage(this.model).subscribe();
  alert("upload successfully");
  this.retreive();
  
}


  

}
}
