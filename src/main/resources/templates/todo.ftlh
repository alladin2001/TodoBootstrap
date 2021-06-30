<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/todo<#if id??>/${id}</#if>" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-6">
                <input type="text" name="description" placeholder="Please, input todo" class="form-control ${(error??)
                ?string('is-invalid', '')}" value="${toDo.description?if_exists}"/>
                <#if error??>
                    <div class="invalid-feedback">
                        ${error}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Target date </label>
            <div class="col-sm-6">
                <input type="date" name="targetDate" class="form-control ${(dateError??)
                ?string('is-invalid', '')}" value="${toDo.targetDate?if_exists}"/>
                <#if dateError??>
                    <div class="invalid-feedback">
                        ${dateError}
                    </div>
                </#if>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-success"><#if id??>Save<#else>Add</#if></button>
    </form>
    <div>
</@c.page>