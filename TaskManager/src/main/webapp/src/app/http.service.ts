import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class HttpService {

    constructor(private httpClient: HttpClient) {}

    /**
     * POST method call
     */
    addTask(body: any, url: string) {
        return this.httpClient.post(url, body, {responseType: 'text'});
    }

    /**
     * POST method call
     */
    updateTask(body: any, url: string) {
        return this.httpClient.post(url, body, {responseType: 'text'});
    }

    /**
     * GET method call
     */
    viewTask(url: string) {
        return this.httpClient.get(url);
    }

    /**
     * GET method call
     */
    getTask(url: string) {
        return this.httpClient.get(url);
    }

    /**
     * GET method call
     */
    endTask(url: string) {
        return this.httpClient.get(url);
    }

}