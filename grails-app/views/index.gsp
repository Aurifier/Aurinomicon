<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
	<head>
		<meta name="layout" content="main"/>
		<title>The Aurinomicon</title>
	</head>
	<body>
        <form>
            <input type="text" name="search" />
            <button>Search</button>
        </form>
        <form>
            <input type="text" name="resourceName" />
            <button>Add Resource</button>
        </form>
        <g:javascript>
            function hasResource(resourceName) {
                return true;
            }
        </g:javascript>
	</body>
</html>
