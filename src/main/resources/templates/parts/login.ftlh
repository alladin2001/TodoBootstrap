<#macro login path>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> User name:</label>
            <div class="col-sm-6">
                <input type="text" name="username" placeholder="input login" class="form-control ${(usernameError??)?string('is-invalid', '')}"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password" placeholder="input password" class="form-control ${(passwordError??)?string('is-invalid', '')}"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
<#--        <div><label> User name:<input type="text" name="username" placeholder="input login"/></label></div>-->
<#--        <div><label> Password:<input type="password" name="password" placeholder="input password"/></label></div>-->
        <#if path == "/registration">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Confirm password:</label>
                <div class="col-sm-6">
                    <input type="password" name="password2" placeholder="repeat password" class="form-control ${(password2Error??)?string('is-invalid', '')}"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#if path == "/login"><a href="/registration">Add new user</a> <#else> <a href="/login">Go to login page</a></#if>
        <button class="btn btn-primary" type="submit"><#if path == "/login">Sign In<#else>Registry</#if></button>
    </form>
</#macro>

<#macro logout>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign out</button>
</#macro>