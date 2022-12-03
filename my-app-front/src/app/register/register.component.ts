import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = new User();
  msg='';

  constructor( private _service : RegisterService, private _router : Router) { } 

  ngOnInit(): void {
  }

  registerUser(){
    this._service.registerUserFromRemote(this.user).subscribe(
      data =>{
        console.log("response received");
        this.msg="Registration successful";
        this._router.navigate(['/login']);
      },
      error => {
        console.log("exception occured");
        this.msg=error.error;
      }
    )
  }

  gotologin(){
    this._router.navigate(['/login']);
  }

}
