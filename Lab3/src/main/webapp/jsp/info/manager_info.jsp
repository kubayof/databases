<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form>
    <div class="form-group row">
        <label for="#${gen.newId("id")}" class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control" id="#${gen.getId("id")}" value="${manager.id}" disabled>
        </div>
    </div>
    <div class="form-group row">
        <label for="#${gen.newId("first_name")}" class="col-sm-2 col-form-label">First name</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control" id="#${gen.getId("first_name")}" value="${manager.firstName}" disabled>
        </div>
    </div>
    <div class="form-group row">
        <label for="#${gen.newId("last_name")}" class="col-sm-2 col-form-label">Last name</label>
        <div class="col-sm-10">
            <input type="password" readonly class="form-control" id="#${gen.getId("last_name")}" placeholder="${manager.lastName}"
                   disabled>
        </div>
    </div>

    <div class="form-group row">
        <label for="project" class="col-sm-2 col-form-label">Project:</label>
        <div class="col-sm-10" id="project">
            <form>
                <div class="form-group row">
                    <label for="#${gen.newId("id")}" class="col-sm-2 col-form-label">Id</label>
                    <div class="col-sm-10">
                        <input type="text" readonly class="form-control" id="#${gen.getId("id")}"
                               value="${manager.project.id}" disabled>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="#${gen.newId("name")}}" class="col-sm-2 col-form-label">Project name</label>
                    <div class="col-sm-10">
                        <input type="text" readonly class="form-control" id="#${gen.getId("name")}"
                               value="${manager.project.name}" disabled>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="form-group row">
        <label for="programmers" class="col-sm-2 col-form-label">Programmers:</label>
        <div class="col-sm-10" id="programmers">
            <c:forEach var="programmer" items="${manager.programmers}">
                <form>
                    <div class="form-group row">
                        <label for="#${gen.newId("id")}" class="col-sm-2 col-form-label">Id</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="#${gen.getId("id")}"
                                   value="${programmer.id}" disabled>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="#${gen.newId("first_name")}" class="col-sm-2 col-form-label">First name</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="#${gen.getId("first_name")}"
                                   value="${programmer.firstName}" disabled>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="#${gen.newId("last_name")}" class="col-sm-2 col-form-label">Last name</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="#${gen.getId("last_name")}"
                                   placeholder="${programmer.lastName}" disabled>
                        </div>
                    </div>
                </form>
                <hr/>
            </c:forEach>
        </div>
    </div>
</form>
