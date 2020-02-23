# marvel-api-integration
-This repository is an integration with marvel-api, but contains only characters API.

<h2>Endpoints</h2>

<h3><b>/marvel-api-int/characters/</b></h3>
Fetches lists of all comic characters registered.

<h4>Response Class</h4>
<b>Array[Character]</b> {<br>
characterSimple (CharacterSimple): Character main information.,<br>
comics (Array[ComicSimple]): A resource list containing comics which feature this character,<br>
events (Array[EventSimple]): A resource list of events in which this character appear.,<br>
series (Array[SeriesSimple]): A resource list of series in which this character appears,<br>
stories (Array[StorySimple]): A resource list of stories in which this character appears<br>
}<br>

<b>CharacterSimple</b> {<br>
id (int): The unique ID of the character resource,<br>
name (string): The name of the character,<br>
description (string): A short bio or description of the character,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}
<b>ComicSimple</b> {<br>
id (int): The unique ID of the comic resource,<br>
title (string): The canonical title of the comic,<br>
description (string): The preferred description of the comic,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource.<br>
pageCount (int): The number of story pages in the comic<br>
}<br>
<b>EventSimple</b> {<br>
id (int): The unique ID of the event resource,<br>
title (string): The canonical title of the event,<br>
description (string): The preferred description of the event,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>
<b>SeriesSimple</b> {<br>
id (int): The unique ID of the series resource,<br>
title (string): The canonical title of the series,<br>
description (string): The preferred description of the series,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>
<b>StorySimple</b> {<br>
id (int): The unique ID of the story resource,<br>
title (string): The canonical title of the story,<br>
description (string): The preferred description of the story,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>

<h3><b>/marvel-api-int/characters/{characterId}</b></h3>
Fetches lists of the comic character requested.

| Parameter | Description | Parameter Type | Data Type |
| --- | --- | --- | --- |
| id | The character ID | path | int |

<h4>Response Class</h4>
<b>Character</b> {<br>
characterSimple (CharacterSimple): Character main information,<br>
comics (Array[ComicSimple]): A resource list containing comics which feature this character,<br>
events (Array[EventSimple]): A resource list of events in which this character appears,<br>
series (Array[SeriesSimple]): A resource list of series in which this character appears,<br>
stories (Array[StorySimple]): A resource list of stories in which this character appears<br>
}<br>

<b>CharacterSimple</b> {<br>
id (int): The unique ID of the character resource,<br>
name (string): The name of the character,<br>
description (string): A short bio or description of the character,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}
<b>ComicSimple</b> {<br>
id (int): The unique ID of the comic resource,<br>
title (string): The canonical title of the comic,<br>
description (string): The preferred description of the comic,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
pageCount (int): The number of story pages in the comic<br>
}<br>
<b>EventSimple</b> {<br>
id (int): The unique ID of the event resource,<br>
title (string): The canonical title of the event,<br>
description (string): The preferred description of the event,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>
<b>SeriesSimple</b> {<br>
id (int): The unique ID of the series resource,<br>
title (string): The canonical title of the series,<br>
description (string): The preferred description of the series,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>
<b>StorySimple</b> {<br>
id (int): The unique ID of the story resource,<br>
title (string): The canonical title of the story,<br>
description (string): The preferred description of the story,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>

<h3><b>/marvel-api-int/characters/{characterId}/{listType}</b></h3>
Fetches the list requested for the character requested. If you query to "comics", 
then the other lists in the ListResponse will be null.

| Parameter | Description | Parameter Type | Data Type |
| --- | --- | --- | --- |
| id | The character ID | path | int |
| list | The list you want to get(possible values are "comics", "events", "series" and "stories") | path | string |
<h4>Response Class</h4>
<b>ListResponse</b> {<br>
comics (Array[ComicSimple], optional): A resource list containing comics which feature this character,<br>
events (Array[EventSimple], optional): A resource list of events in which this character appears,<br>
series (Array[SeriesSimple], optional): A resource list of series in which this character appears,<br>
stories (Array[StorySimple], optional): A resource list of stories in which this character appears<br>
}<br>
<b>ComicSimple</b> {<br>
id (int): The unique ID of the comic resource,<br>
title (string): The canonical title of the comic,<br>
description (string): The preferred description of the comic,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
pageCount (int): The number of story pages in the comic<br>
}<br>
<b>EventSimple</b> {<br>
id (int): The unique ID of the event resource,<br>
title (string): The canonical title of the event,<br>
description (string): The preferred description of the event,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>
<b>SeriesSimple</b> {<br>
id (int): The unique ID of the series resource,<br>
title (string): The canonical title of the series,<br>
description (string): The preferred description of the series,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>
<b>StorySimple</b> {<br>
id (int): The unique ID of the story resource,<br>
title (string): The canonical title of the story,<br>
description (string): The preferred description of the story,<br>
modified (Date): The date the resource was most recently modified,<br>
resourceURI (string): The canonical URL identifier for this resource<br>
}<br>