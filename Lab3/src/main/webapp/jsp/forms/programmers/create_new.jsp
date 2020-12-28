<div class="card">
    <div class="card-header">
        <h5 class="mb-0">
            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#${gen.newId("collapse")}"
                    aria-expanded="false" aria-controls="${gen.getId("collapse")}">
                Insert new
            </button>
        </h5>
    </div>
    <div id="${gen.getId("collapse")}" class="collapse" data-parent="#${gen.getId("accordion")}">
        <div class="card-body">
            <form action="/programmers/new" method="POST">
                <div class="form-group">
                    <label for="${gen.newId("first_name")}">First name</label>
                    <input type="text" class="form-control" id="${gen.getId("first_name")}" name="firstName" value="Name">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("last_name")}">First name</label>
                    <input type="text" class="form-control" id="${gen.getId("last_name")}" name="lastName" value="Name">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("manager_id")}">Manger Id</label>
                    <input type="number" class="form-control" id="${gen.getId("manager_id")}" name="managerId" value="1" min="1">
                </div>
                <button type="submit" class="btn btn-primary">Insert</button>
            </form>
        </div>
    </div>
</div>