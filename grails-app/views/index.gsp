<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" style="height: 100%">
	<head>
        <meta name="layout" content="main" />
		<title>The Aurinomicon</title>
	</head>
	<body style="height: 100%">
        <form>
            <input type="text" name="search" />
            <button type="button" onclick="searchResource(this.form.search.value)">Search</button>
        </form>
        <form>
            <input type="text" name="resourceName" />
            <button type="button" onclick="addResource(this.form.resourceName.value)">Add Resource</button>
        </form>
        <div id="cy" style="height: 100%"></div>
        <g:javascript>
            $('#cy').cytoscape({
                style: [
                    {
                        selector: 'node',
                        css: {
                            'content': 'data(name)'
                        }
                    }
                ]
            });
            function addResource(name) {
                $.post('<g:createLink uri="/resources" />', {name: name});
            }
            function searchResource(name) {
                var cy = $('#cy').cytoscape('get');
                $.getJSON('<g:createLink uri="/resources/" />', function(resources) {
                    for(var i = 0; i < resources.length; i++)
                        if(name === resources[i].name) {
                            cy.add({group: "nodes", data: {name: resources[i].name}});
                            cy.layout({name: 'grid'});
                        }
                    }
                );
            }
            function hasResource(resourceName) {
                var cy = $('#cy').cytoscape('get');
                var nodes = cy.filter("node[name = '" + resourceName + "']");
                if (nodes.size() > 0) {
                    return true;
                }

                return false;
            }
        </g:javascript>
	</body>
</html>
