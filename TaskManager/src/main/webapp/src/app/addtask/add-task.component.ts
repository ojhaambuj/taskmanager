import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';


@Component( {
    templateUrl: './add-task.component.html',
    providers: [HttpService],
    styles: []
} )
export class AddTaskComponent implements OnInit {

    taskForm: FormGroup;
    edit: boolean;

    constructor( private fb: FormBuilder, private router: Router, private route: ActivatedRoute, private _httpService: HttpService ) { }

    ngOnInit() {
        this.initForm();
        this.route.params.subscribe(params => {
            if (params.task) {
                this.loadTask( params.task );
            }
        });
    }

    initForm(): void {
        this.taskForm = this.fb.group( {
            task: [null],
            priority: [0],
            parentTask: [null],
            startDate: [null],
            endDate: [null]
        } );
    }
    
    loadTask(task: any): void {
        this.edit = true;
        this._httpService.getTask("./getTask?taskName=" + task).subscribe(
            (data: any) =>{
                this.taskForm.setValue(data);
                this.taskForm.updateValueAndValidity();
            },
            error => {
                console.log(error);
            }
        );
        
    }

    manageTask() {
        if (this.edit) {
            this._httpService.addTask(this.taskForm.value, "./updateTask").subscribe(
                data =>{
                    if (data == 'Success') {
                        this.taskForm.reset();
                    }
                    alert(data); 
                    this.router.navigate(['/view-task']);
                },
                error => {
                    console.log(error);
                }
            );
        } else {
            this._httpService.addTask(this.taskForm.value, "./addTask").subscribe(
                data =>{
                    if (data == 'Success') {
                        this.taskForm.reset();
                    }
                    alert(data); 
                },
                error => {
                    console.log(error);
                }
            );
        }
    }

}
