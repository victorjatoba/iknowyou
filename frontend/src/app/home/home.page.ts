import { Component, OnInit } from '@angular/core';
import { BloodType } from './model/blood-type.model';
import { IonicSelectableComponent } from 'ionic-selectable';
import { Patient } from './model/patient.model';
import { ApiService } from '../api/api.service';
import { ApiRoute } from '../api/api-route.enum';

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
            birthdate: '10/21/1988',
            bloodType: BloodType.O_NEGATIVE,
            keywords: ['diabets', 'lupus']
        },
        {
            id: '2',
            name: 'Matheus Silva',
            birthdate: '03/11/1992',
            bloodType: BloodType.A_POSITIVE,
            keywords: ['Relapsing Polychondritis', 'lupus', 'Scleroderma', 'celiac', 'toothache', 'headache']
        },
        {
            id: '3',
            name: 'Luigi Scarminio',
            birthdate: '01/27/1982',
            bloodType: BloodType.B_NEGATIVE,
            keywords: ['celiac', 'lupus', 'Scleroderma']
        }
    ];

    constructor(public apiService: ApiService) { }

    ngOnInit() {

        this.apiService.getWithNoAuth(ApiRoute.PATIENTS)
            .subscribe(res => {
                console.log(res);
            });
    }

    searchPatient(event: {
        component: IonicSelectableComponent,
        value: any
    }) {
        console.log(this.selectedPatient);
    }
}
