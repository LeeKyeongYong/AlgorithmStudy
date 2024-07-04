<div>
    <div>상품 종류</div>
    <div th:each="type : ${itemTypes}" class="form-check form-check-inline">
        <input type="radio" th:field="*{itemType}" th:value="${type.name()}"
        class="form-check-input">
            <label th:for="${#ids.prev('itemType')}" th:text="${type.description}"
            class="form-check-label">
                    BOOK
            </label>
    </div>
</div>






