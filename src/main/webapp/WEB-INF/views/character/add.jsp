<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form modelAttribute="character" action="add" method="post">
	<fieldset>
		<legend>Add Character</legend>
		<p>
			<form:label path="name" cssErrorClass="error">Name</form:label><br />
			<form:input path="name" /><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="name" />
		</p>
		<p>
			<form:label path="characterClass" cssErrorClass="error">Class</form:label><br />
			<form:input path="characterClass"/><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="characterClass" />
		</p>
		<p>
			<form:label path="Level">Level</form:label><br />
			<form:input path="level"/>
		</p>
		<p>
			<form:button>Submit</form:button>
		</p>
	</fieldset>
</form:form>