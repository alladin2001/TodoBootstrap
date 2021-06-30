<#import "login.ftlh" as l>

<#include "security.ftlh">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">ToDo</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Home</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <#if know>
        <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
<#--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
<#--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
          <@l.logout/>
<#--            <div class="my-2 my-sm-0">-->
<#--                ${name?if_exists}-->
<#--            </div>-->
        </form>
        </#if>
    </div>
</nav>