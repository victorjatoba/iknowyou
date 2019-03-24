import { Component } from '@angular/core';
import { BloodType } from './model/blood-type.model';
import { IonicSelectableComponent } from 'ionic-selectable';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
})
export class HomePage {

    selectedCustomer: string;

    customerList = [
        {
            id: '1',
            name: 'Victor Jatobá',
            birthdate: '10/21/1988',
            bloodType: BloodType.O_NEGATIVE
        },
        {
            id: '2',
            name: 'Matheus Silva',
            birthdate: '03/11/1992',
            bloodType: BloodType.A_POSITIVE
        },
        {
            id: '3',
            name: 'Luigi Scarminio',
            birthdate: '01/27/1982',
            bloodType: BloodType.B_NEGATIVE
        }
    ];

    searchCustomers2(): Array<any> {
        console.log(this.customerList.map(it => (it.name)));

        return this.customerList
            .map(it => (
                it.name.includes(this.selectedCustomer)
            ));
    }

    searchCustomers(event: {
        component: IonicSelectableComponent,
        value: any
    }) {
        console.log(event.value);
    }
}
