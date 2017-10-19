import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
import {UserComponent} from "./user/user.component";

const routes: Routes = [
    {
        path: '', component: LayoutComponent,
        children: [
            { path: 'tables', loadChildren: './tables/tables.module#TablesModule' },
            { path: 'forms', loadChildren: './form/form.module#FormModule' },
            { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
            { path: 'charts', loadChildren: './charts/charts.module#ChartsModule' },
            { path: 'create-program', loadChildren: './create-program/create-program.module#CreateProgramModule' },
            { path: 'edit-program', loadChildren: './edit-program/edit-program.module#EditProgramModule' },
            { path: 'program-list', loadChildren: './program-list/program-list.module#ProgramListModule' },
            { path: 'bs-element', loadChildren: './bs-element/bs-element.module#BsElementModule' },
            { path: 'grid', loadChildren: './grid/grid.module#GridModule' },
            { path: 'components', loadChildren: './bs-component/bs-component.module#BsComponentModule' },
            { path: 'blank-page', loadChildren: './blank-page/blank-page.module#BlankPageModule' },
            { path: 'program-list', loadChildren: './program-list/program-list/program-list.module#ProgramListModule'},
            { path: 'user', loadChildren:'./user/user.module#UserModule'},

            ]

    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule { }
