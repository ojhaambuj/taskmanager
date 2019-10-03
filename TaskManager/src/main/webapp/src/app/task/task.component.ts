
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  
  addTask: FormGroup;
  viewTask: FormGroup;
  showAddTask = true;
  showViewTask: boolean;
  taskList: any[];
  originalTasks: any[];
  edit:boolean;
  message: string;

  constructor(private formBuilder: FormBuilder, private httpService: HttpService) { }
  
  

  ngOnInit() {
    this.loadTask();

    this.addTask = this.formBuilder.group({
      taskName:[null],
      priority:[null],
      parentTask:[null],
      startDate:[null],
      endDate:[null]
    })
    this.viewTask = this.formBuilder.group({
      taskName:[""],
      parentTask:[""],
      priorityForm:[""],
      priorityTo:[""],
      startDate:[""],
      endDate:[""]
    });
    this.viewTask.valueChanges.subscribe(value => {
      this.filterTasks(value);
    });
  }

  loadTask() {
    this.httpService.viewTask('./viewTask').subscribe((data: any)=> {
      this.taskList = data;
      this.originalTasks = data;
    });
  }

  saveTask() {
    let newTask = this.addTask.value;
    if(this.edit) {
      this.httpService.updateTask(newTask,'./updateTask').subscribe((data: any)=> {
        if(data == "Success") {
          this.addTask.reset();
          this.edit = false;
          this.message = "Task updated successfully..!!";
          this.loadTask();
        } else {
          if(data == "Success") {
            this.message = "Task update failed..!!";
          }
        }
      });  
    } else {
      // call service add task
      this.httpService.addTask(newTask,'./addTask').subscribe((data: any)=> {
        if(data == "Success") {
          this.addTask.reset();
          this.message = "Task added successfully..!!";
          this.loadTask();
        } else {
          if(data == "Success") {
            this.message = "Task create failed..!!";
          }
        }
      });
    }
  }

  deleteRow(taskName){
    this.httpService.endTask('./endTask/'+taskName).subscribe((data: any)=> {
      if (data != null) {
        this.originalTasks = data;
        this.taskList = data;
    }
  },
  error => {
      console.log(error);
  
    });
  }

  editTask(task) {
    this.edit = true;
    this.addTask.setValue(task);
    this.addTask.updateValueAndValidity();
    this.showAddTask=true;
    this.showViewTask=false
  }

  filterTasks(values) {
    this.originalTasks = this.taskList.filter(task => {
      if(values.taskName == "" && values.parentTask == ""  && 
      values.startDate=="" && values.endDate=="" && values.priorityTo=="" && values.priorityForm=="") {
        return true;
      }
       return (values.taskName != "" && task.taskName.toLowerCase().indexOf(values.taskName.toLowerCase()) != -1) ||
       (values.parentTask != "" && task.parentTask.toLowerCase().indexOf(values.parentTask.toLowerCase()) != -1)  ||
 
       (values.startDate != "" && new Date(task.startDate) >= new Date(values.startDate)  &&
        values.endDate != "" && new Date(task.endDate) <= new Date(values.endDate))  ||
       (values.startDate != "" && values.endDate == "" && new Date(task.endDate)>= new Date(values.startDate)) ||
       (values.endDate != "" && values.startDate == "" && new Date(task.startDate) <= new Date(values.endDate)) ||

       (values.priorityForm != "" && task.priority >= values.priorityForm &&
       values.priorityTo != "" && task.priority <= values.priorityTo) ||
       (values.priorityForm != "" && values.priorityTo == "" && task.priority >= values.priorityForm) ||
       (values.priorityTo != "" && values.priorityForm == "" && task.priority <= values.priorityTo)

    });
  }

}
