import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';
import { environment } from 'src/environments/environment';



@Injectable({
  providedIn: 'root'
})
export class HospitalService {
	
	private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }
  public getDoctors():Observable<Doctor[]>{
	//return this.http.get<Doctor[]>('${this.apiServerUrl}/doctor/all');
	return this.http.get<Doctor[]>(`${this.apiServerUrl}/doctor/all`);
  }
  
  public addDoctor(doctor:Doctor):Observable<Doctor>{
	return this.http.post<Doctor>(`${this.apiServerUrl}/doctor/add`, doctor);
  }
  
  public updateDoctor(doctor: Doctor): Observable<Doctor> {
    return this.http.put<Doctor>(`${this.apiServerUrl}/doctor/update`, doctor);
  }

  public deleteDoctor(doctorId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/doctor/delete/${doctorId}`);
  }
  
  parseDate(dateString: string): Date {
    if (dateString) {
        return new Date(dateString);
    }
    return null;
}
}
