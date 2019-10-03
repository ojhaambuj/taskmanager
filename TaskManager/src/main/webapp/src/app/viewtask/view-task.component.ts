import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';


@Component( {
    templateUrl: './view-task.component.html',
    providers: [HttpService],
    styles: []
} )
export class ViewTaskComponent implements OnInit {

    searchForm: FormGroup;
    tasks: any[];
    formFilters: any;

    constructor( private fb: FormBuilder, private router: Router, private _httpService: HttpService ) { }

    ngOnInit() {
        this.initForm();
        this._httpService.viewTask("./viewTask").subscribe(
            (data: any[]) =>{
                if (data != null) {
                    this.tasks = data;
                }
            },
            error => {
                console.log(error);
            }
        );
        
        this.searchForm.valueChanges.subscribe( value => {
            this.formFilters = value;
        } );
    }

    initForm(): void {
        this.searchForm = this.fb.group( {
            task: [null],
            parentTask: [null],
            priorityFrom: [null],
            priorityTo: [null],
            startDate: [null],
            endDate: [null]
        } );
    }

    editTask(task): void {
        this.router.navigate(['/add-task', task]);
    }

    endTask(task): void {
        this._httpService.endTask("./endTask?taskName=" + task).subscribe(
            (data: any[]) =>{
                if (data != null) {
                    this.tasks = data;
                }
            },
            error => {
                console.log(error);
            }
        );
    }

}
