<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form>
    <div class="form-group row">
        <label for="id" class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control" id="id" value="${technology.id}" disabled>
        </div>
    </div>
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">Technology name</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control" id="name" value="${technology.name}" disabled>
        </div>
    </div>
</form>