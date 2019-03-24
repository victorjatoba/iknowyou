import { ApiGenericService } from './api-generic.service';
import { Injectable } from '@angular/core';
import { ApiRoute } from './api-route.enum';

@Injectable({
    providedIn: 'root'
})
export class ApiService extends ApiGenericService {

    getPatients() {
        return this.getWithNoAuth(ApiRoute.PATIENTS);
    }

    getKeywordsByPatient(patientId) {
        const endpoint = `${ApiRoute.KEYWORDS}/${patientId}`;
        return this.getWithNoAuth(endpoint);
    }
}
