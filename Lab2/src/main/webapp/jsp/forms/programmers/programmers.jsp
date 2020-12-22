<div class="card">
    <div class="card-header" id="programmersHeading">
        <h5 class="mb-0">
            <button class="btn btn-link" aria-expanded="true"
                    aria-controls="collapseOne">
                Programmers
            </button>
        </h5>
    </div>

    <div class="show" aria-labelledby="programmersHeading">
        <div class="card-body">

            <div id="${gen.newId("accordion")}">
                <jsp:include page="/jsp/forms/programmers/get_by_id.jsp"/>
                <jsp:include page="/jsp/forms/programmers/get_by_first_name.jsp"/>
                <jsp:include page="/jsp/forms/programmers/get_by_last_name.jsp"/>
                <jsp:include page="/jsp/forms/programmers/get_by_manager_id.jsp"/>
                <jsp:include page="/jsp/forms/programmers/get_by_technology_id.jsp"/>
                <jsp:include page="/jsp/forms/programmers/create_new.jsp"/>
                <jsp:include page="/jsp/forms/programmers/update.jsp"/>
                <jsp:include page="/jsp/forms/programmers/delete.jsp"/>
            </div>
        </div>
    </div>
</div>