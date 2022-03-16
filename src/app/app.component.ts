import { Component, OnInit } from '@angular/core';

import { Doctor } from './doctor';
import { HospitalService } from './hospital.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  public doctors: Doctor[] = [];
  public editDoctor!: Doctor ;
  public deleteDoctor!: Doctor ;
  title = 'hospital_demo_postulation';
 	
  
  constructor(private hospitalService: HospitalService){}
  
  ngOnInit() {
    this.getDoctors();
  }
  
  public getDoctors(): void {
    this.hospitalService.getDoctors().subscribe(
      (response: Doctor[]) => {
        this.doctors = response;
        console.log(this.doctors);
      },
      (error: HttpErrorResponse) => {
		console.log(error.message);
        alert(error.message);
      }
    );
  }
  
  public onAddDoctor(addForm: NgForm): void {
    document.getElementById('add-doctor-form')!.click();
    this.hospitalService.addDoctor(addForm.value).subscribe(
      (response: Doctor) => {
        console.log(response);
        this.getDoctors();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateDoctor(doctor: Doctor): void {
    this.hospitalService.updateDoctor(doctor).subscribe(
      (response: Doctor) => {
        console.log(response);
        this.getDoctors();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
//
  public onDeleteDoctor(doctorId: number): void {
    this.hospitalService.deleteDoctor(doctorId).subscribe(
      (response: void) => {
        console.log(response);
        this.getDoctors();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
//
  public searchDoctors(key: string): void {
    console.log(key);
    const results: Doctor[] = [];
    for (const doctor of this.doctors) {
      if (doctor.names.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || doctor.lastNames.toLowerCase().indexOf(key.toLowerCase()) !== -1
      ) {
        results.push(doctor);
      }
    }
    this.doctors = results;
    if (results.length === 0 || !key) {
      this.getDoctors();
    }
  }

  public onOpenModal(doctor: Doctor , mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addDoctorModal');
    }
    if (mode === 'edit') {	
      		this.editDoctor = doctor;
      button.setAttribute('data-target', '#updateDoctorModal');
    }
    if (mode === 'delete') {
      this.deleteDoctor = doctor;
      button.setAttribute('data-target', '#deleteDoctorModal');
    }
    container!.appendChild(button);
    button.click();
  }
	
  
}
