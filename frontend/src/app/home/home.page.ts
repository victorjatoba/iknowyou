import { Component, OnInit } from '@angular/core';
import { BloodType } from './model/blood-type.model';
import { IonicSelectableComponent } from 'ionic-selectable';
import { Patient } from './model/patient.model';
import { ApiService } from '../api/api.service';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

    selectedPatient: Patient;

    patients = [
        {
            id: '1',
            name: 'Victor Jatobá',
            age: '21',
            bloodType: BloodType.O_NEGATIVE,
            keywords: ['diabets', 'lupus']
        },
        {
            id: '2',
            name: 'Matheus Silva',
            age: '32',
            bloodType: BloodType.A_POSITIVE,
            keywords: ['Relapsing Polychondritis', 'lupus', 'Scleroderma', 'celiac', 'toothache', 'headache']
        },
        {
            id: '3',
            name: 'Luigi Scarminio',
            age: '40',
            bloodType: BloodType.B_NEGATIVE,
            keywords: ['celiac', 'lupus', 'Scleroderma']
        }
    ];

    keywords = [];

    constructor(public apiService: ApiService) { }

    ngOnInit() {

        this.getKeywords();
    }

    searchPatient(event: {
        component: IonicSelectableComponent,
        value: any
    }) {
        this.getPatients();
        this.getKeywords();
    }

    private getKeywords() {
        const keyObservable = this.apiService.getKeywordsByPatient(this.selectedPatient.id)
            .subscribe(res => {
                console.log(res);
                this.keywords = res;
                keyObservable.unsubscribe();
            });
    }

    private getPatients() {
        const patientsObservable = this.apiService.getPatients()
            .subscribe(res => {
                console.log(res);
                this.patients = res;
                patientsObservable.unsubscribe();
            });
    }
}
