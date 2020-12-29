<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form>
    <div class="form-group row">
        <label for="id" class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control" id="id" value="${programmer.id}" disabled>
        </div>
    </div>
    <div class="form-group row">
        <label for="first_name" class="col-sm-2 col-form-label">First name</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control" id="first_name" value="${programmer.firstName}" disabled>
        </div>
    </div>
    <div class="form-group row">
        <label for="last_name" class="col-sm-2 col-form-label">Last name</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="last_name" placeholder="${programmer.lastName}" disabled>
        </div>
    </div>
</form>