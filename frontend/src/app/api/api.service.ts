import { HttpClient, HttpHeaders, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Observable, Subject, throwError } from 'rxjs';
import { catchError, timeout } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';

/**
 * @description
 * It contains the basic methods that can be easily
 * called by subclasses and have a considerable source code reused.
*/
@Injectable({
    providedIn: 'root'
})
export class ApiService {

    /**
     * Attibute that defines the timeout for REST HTTP calls
     */
    static readonly EIGHT_SECONDS_TIMEOUT = environment.API_TIMEOUT;

    /**
     * It stores the base of the URL used in the resources' consumption.
     */
    static apiUrl = environment.API_URL;
    static token = '';

    /**
     * It represents the object that will manage the notifications of config applications to other objects.
     */
    applyConfigurationSubject = new Subject<any>();

    /**
     * It represents the object that will manage the notifications of successful login to other objects.
     */
    loginSuccessfulSubject = new Subject<any>();

    /**
     * It builds the generic service object with the http client used in the REST HTTP operations.
     * @param httpClient object that manages the REST HTTP operations
     */
    constructor(public httpClient: HttpClient) { }

    /**
     * This method create a resource by sending a POST message to the Zeus API with authentication token in the header.
     * @param endpoint route indicating the used resource
     * @param item object to be created in the router
     */
    create(endpoint: string, item: any): Observable<any> {
        const url = `${ApiService.apiUrl}/${endpoint}`;
        return this.httpClient
            .post(
                url,
                item,
                this.getHTTPHeader()
            ).pipe(
                timeout(ApiService.EIGHT_SECONDS_TIMEOUT),
                catchError(this.handleError) // then handle the error
            );
    }

    /**
     * This method updates a resource by sending a PUT message to the Zeus API with authentication token in the header.
     * @param endpoint route indicating the used resource
     * @param item object ID to be updated
     */
    update(endpoint: string, item: any): Observable<any> {
        const url = `${ApiService.apiUrl}/${endpoint}`;
        return this.httpClient
            .put(
                url,
                item,
                this.getHTTPHeader()
            ).pipe(
                timeout(ApiService.EIGHT_SECONDS_TIMEOUT),
                catchError(this.handleError) // then handle the error
            );
    }

    /**
     * This method retrieves a resource by sending a GET message to the Zeus API with authentication token in the header.
     * @param endpoint route indicating the used resource
     */
    get(endpoint: string): Observable<any> {
        const url = `${ApiService.apiUrl}/${endpoint}`;
        return this.httpClient
            .get(
                url,
                this.getHTTPHeader()
            ).pipe(
                timeout(ApiService.EIGHT_SECONDS_TIMEOUT),
                catchError(this.handleError) // then handle the error
            );
    }

    /**
     * This method retrieves a resource by sending a GET message any URL without putting the Zeus API prefix.
     * @param endpoint route indicating the used resource
     */
    getWithoutPrefix(endpoint: string): Observable<any> {
        return this.httpClient
            .get(
                endpoint,
                this.getHTTPHeader()
            ).pipe(
                timeout(ApiService.EIGHT_SECONDS_TIMEOUT),
                catchError(this.handleError) // then handle the error
            );
    }

    /**
     * This method retrieves a resource by sending a GET message to the Zeus API without authentication.
     * @param endpoint route indicating the used resource
     */
    getWithNoAuth(endpoint: string): Observable<any> {
        const url = `${ApiService.apiUrl}/${endpoint}`;
        return this.httpClient
            .get(
                url,
                {
                    headers: new HttpHeaders({
                        'Content-Type': 'application/json',
                    })
                }
            ).pipe(
                timeout(ApiService.EIGHT_SECONDS_TIMEOUT),
                catchError(this.handleError) // then handle the error
            );
    }

    /**
     * This method removes a resource by sending a PUT message to the Zeus API with authentication token in the header.
     * @param endpoint route indicating the used resource
     * @param id object ID to be deleted
     */
    delete(endpoint: string, id: number): Observable<any> {
        const url = `${ApiService.apiUrl}/${endpoint}/${id}`;
        return this.httpClient
            .delete(
                url,
                this.getHTTPHeader()
            ).pipe(
                timeout(ApiService.EIGHT_SECONDS_TIMEOUT),
                catchError(this.handleError) // then handle the error
            );
    }

    /**
     * This method send a remove HTTP requesto to the url without body / content.
     * @param endpoint route indicating the used resource
     */
    deleteWithoutBody(endpoint: string): Observable<any> {
        const url = `${ApiService.apiUrl}/${endpoint}`;
        return this.httpClient
            .delete(
                url,
                this.getHTTPHeader()
            ).pipe(
                timeout(ApiService.EIGHT_SECONDS_TIMEOUT),
                catchError(this.handleError) // then handle the error
            );
    }

    /**
     * This method builds the HTTP header with JSON application content and the API-generated token.
     */
    getHTTPHeader() {
        return {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': ApiService.token
            })
        };
    }

    /**
     * Method that handle error when the request isn't succesfull.
     *
     * @param error Error type.
     */
    handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            console.error(
                `Backend returned code ${error.status},` +
                `\nBody was: ${error.error},` +
                `\nDetailed error: ${JSON.stringify(error)}`);
        }
        // return an observable with a user-facing error message
        return throwError(error);
    }

}
