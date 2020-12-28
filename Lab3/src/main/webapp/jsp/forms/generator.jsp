<div class="card">
    <div class="card-header" id="managersHeading">
        <h5 class="mb-0">
            <button class="btn btn-link" aria-expanded="true"
                    aria-controls="collapseOne">
                Populate wirh randomized data
            </button>
        </h5>
    </div>

    <div class="show" aria-labelledby="managersHeading">
        <div class="card-body">
            <form action="/populate" method="POST">
                <div class="form-group">
                    <label for="${gen.newId("id")}">Managers count</label>
                    <input type="number" class="form-control" id="${gen.getId("id")}" name="managers_count" value="1" min="1">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("id")}">Programmers count</label>
                    <input type="number" class="form-control" id="${gen.getId("id")}" name="programmers_count" value="1" min="1">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("id")}">Projects count</label>
                    <input type="number" class="form-control" id="${gen.getId("id")}" name="projects_count" value="1" min="1">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("id")}">Technologies count</label>
                    <input type="number" class="form-control" id="${gen.getId("id")}" name="technologies_count" value="1" min="1">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("id")}">ProgrammersTechnologies count</label>
                    <input type="number" class="form-control" id="${gen.getId("id")}" name="programmers_technologies_count" value="1" min="1">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("id")}">ProjectsTechnologies count</label>
                    <input type="number" class="form-control" id="${gen.getId("id")}" name="projects_technologies_count" value="1" min="1">
                </div>
                <button type="submit" class="btn btn-primary">Populate</button>
            </form>
        </div>
    </div>
</div>