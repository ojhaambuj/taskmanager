import { Pipe, PipeTransform } from '@angular/core';

@Pipe( { name: 'taskFilter' } )
export class TaskFilterPipe implements PipeTransform {

    transform( tasks: any[], filters: any ): any[] {
        if ( filters == undefined || filters == null ) {
            return tasks;
        }

        return tasks.filter( task => {
            return (filters.task == ''|| filters.task == null || task.task.indexOf(filters.task) != -1)
                && (filters.parentTask == ''|| filters.parentTask == null || task.parentTask.indexOf(filters.parentTask) != -1)
                && this.isPriorityInRange( task.priority, filters.priorityFrom, filters.priorityTo )
                && (filters.startDate == null || this.areDatesEqual( new Date( task.startDate ), new Date( filters.startDate ) ))
                && (filters.endDate == null || this.areDatesEqual( new Date( task.endDate ), new Date( filters.endDate ) ));
        });
    }

    isPriorityInRange( priority, from, to ): boolean {
        if ( from != null && from != '' && to != null && to != '') {
            return priority >= from && priority <= to;
        } else if ( from != null && from != '') {
            return priority >= from;
        } else if ( to != null && to != '') {
            return priority <= to;
        } else {
            return true;
        }
    }

    areDatesEqual( date1, date2 ): boolean {
        return ( date1.getFullYear() === date2.getFullYear() ) &&
            ( date1.getMonth() === date2.getMonth() ) &&
            ( date1.getDate() == date2.getDate() );
    }

}