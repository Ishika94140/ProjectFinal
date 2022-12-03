import { Component, OnInit } from '@angular/core';
import { Abstract } from '../abstract';
import { EditabstractService } from '../editabstract.service';
import { Router } from '@angular/router';
import { ShareConfig } from 'rxjs';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-edit-abstract',
  templateUrl: './edit-abstract.component.html',
  styleUrls: ['./edit-abstract.component.css'],
  providers: [DatePipe]
})

export class EditAbstractComponent implements OnInit {

  abstract:Abstract = new Abstract();
  today = new Date();

  constructor(private editabstractService : EditabstractService) { }

  ngOnInit(): void {
  }

  submitAbstract(){
    console.log(this.abstract);
    this.editabstractService.submitAbstract(this.abstract).subscribe(data=>{
      alert("Successfully submit your abstract")
    },error=>alert("Sorry we can't submit your abstract"));
  }

  }







