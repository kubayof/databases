<div class="card">
    <div class="card-header">
        <h5 class="mb-0">
            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#${gen.newId("collapse")}"
                    aria-expanded="false" aria-controls="programmersTechnologiesCollapseFour">
                Insert new
            </button>
        </h5>
    </div>
    <div id="${gen.getId("collapse")}" class="collapse" data-parent="#${gen.getId("accordion")}">
        <div class="card-body">
            <form action="/programmers_technologies/new" method="POST">
                <div class="form-group">
                    <label for="${gen.newId("programmer_id")}">Programmer Id</label>
                    <input type="number" class="form-control" id="${gen.getId("programmer_id")}" name="programmerId" value="1" min="1">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("technology_id")}">Technology Id</label>
                    <input type="number" class="form-control" id="${gen.getId("technology_id")}" name="technologyId" value="1" min="1">
                </div>
                <button type="submit" class="btn btn-primary">Insert</button>
            </form>
        </div>
    </div>
</div>