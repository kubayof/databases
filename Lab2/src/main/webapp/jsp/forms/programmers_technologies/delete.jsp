<div class="card">
    <div class="card-header">
        <h5 class="mb-0">
            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#${gen.newId("collapse")}"
                    aria-expanded="false" aria-controls="${gen.getId("collapse")}">
                Delete by Id
            </button>
        </h5>
    </div>
    <div id="${gen.getId("collapse")}" class="collapse" data-parent="#${gen.getId("accordion")}">
        <div class="card-body">
            <form action="/programmers_technologies/delete" method="POST">
                <div class="form-group">
                    <label for="${gen.newId("programmer_id")}">Programmer Id</label>
                    <input type="number" class="form-control" id="${gen.getId("programmer_id")}" name="programmer_id" value="1" min="1">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("technology_id")}">Technology Id</label>
                    <input type="number" class="form-control" id="${gen.getId("technology_id")}" name="technology_id" value="1" min="1">
                </div>
                <button type="submit" class="btn btn-primary">Delete</button>
            </form>
        </div>
    </div>
</div>