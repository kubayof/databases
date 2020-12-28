<div class="card">
    <div class="card-header" id="programmersHeading">
        <h5 class="mb-0">
            <button class="btn btn-link" aria-expanded="true"
                    aria-controls="collapseOne">
                Technologies
            </button>
        </h5>
    </div>

    <div class="show" aria-labelledby="programmersHeading">
        <div class="card-body">

            <div id="${gen.newId("accordion")}">
                <jsp:include page="/jsp/forms/technologies/get_by_id.jsp"/>
                <jsp:include page="/jsp/forms/technologies/get_by_programmer_id.jsp"/>
                <jsp:include page="/jsp/forms/technologies/get_by_project_id.jsp"/>
                <jsp:include page="/jsp/forms/technologies/get_by_name.jsp"/>
                <jsp:include page="/jsp/forms/technologies/create_new.jsp"/>
                <jsp:include page="/jsp/forms/technologies/update.jsp"/>
                <jsp:include page="/jsp/forms/technologies/delete.jsp"/>
            </div>
        </div>
    </div>
</div>