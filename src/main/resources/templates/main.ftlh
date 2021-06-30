<#import "parts/common.ftlh" as c>
<@c.page>

        <div class="row py-2">
        <div class="col-12">
                <a class="btn btn-primary" href="/todo">Add Todo</a>
        </div>
        <div class="col-12">
        <#if toDos?has_content>
        <table class="table table-bordered my-2">
                <thead>
                <tr>
                        <#--                                        <th scope="col">Id</th>-->
                        <th scope="col">Description</th>
<#--                        <th scope="col">User</th>-->
                        <th scope="col">Last update</th>
                        <th scope="col">Target date</th>
                        <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <#list toDos as toDo>
                        <tr>
                                <#--                                        <th scope="row">1</th>-->
                                <td>${toDo.description}</td>
<#--                                <td>${toDo.authorUsername}</td>-->
                                <td>${toDo.createDate}</td>
                                <td><#if toDo.targetDate??>${toDo.targetDate}<#else>None</#if></td>
                                <td class="col-2" align="center">
                                        <a class="btn btn-success" href="/todo/done/${toDo.id}"><i class="fas fa-check"></i></a>
                                        <a class="btn btn-warning" href="/todo/${toDo.id}"><i class="far fa-edit"></i></a>
                                        <a class="btn btn-danger" href="/todo/delete/${toDo.id}"><i class="far fa-trash-alt"></i></a>
                                </td>
                        </tr>
                </#list>
                </tbody>
        </table>
        <#else>
        <div>No toDos
                <div>
                        </#if>
                </div>

</@c.page>