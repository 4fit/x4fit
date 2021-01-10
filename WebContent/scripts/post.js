function Editor() {
	return new SimpleMDE({
		element: document.getElementById("content"),
		toolbar: ["bold", "italic", "strikethrough", "|",
			"heading-1", "heading-2", "heading-3", "|",
			"unordered-list", "ordered-list", "link", "image", "table", "horizontal-rule", "|",
			"quote", "code", "|",
			"preview", "side-by-side", "fullscreen", "|",
			{
				name: "guide",
				action: (editor) => {
					var win = window.open("https://www.markdownguide.org/cheat-sheet/", '_blank');
					win.focus();
				},
				className: "fa fa-question-circle",
				title: "Markdown Guide",
			},
		],
		spellChecker: false,
		promptURLs: true,
		placeholder: "Bài viết có thể hiển thị với định dạng Markdown.",
		renderingConfig: {
			codeSyntaxHighlighting: true,
		},
	});
}

function ViewContent() {
	return new SimpleMDE({
		element: document.getElementById("content"),
		toolbar: false,
		status: false,
		spellChecker: false,
		renderingConfig: {
			codeSyntaxHighlighting: true,
		},
	});
}

function Comment() {
	return new SimpleMDE({
		element: document.getElementById("cmt"),
		toolbar: ["bold", "italic", "strikethrough", "|",
			"heading-1", "heading-2", "heading-3", "|",
			"unordered-list", "ordered-list", "link", "image", "table", "horizontal-rule", "|",
			"quote", "code", "|",
			"preview", "side-by-side", "fullscreen", "clean-block", "|",
			{
				name: "guide",
				action: (editor) => {
					var win = window.open("https://www.markdownguide.org/cheat-sheet/", '_blank');
					win.focus();
				},
				className: "fa fa-question-circle",
				title: "Markdown Guide",
			},],
		spellChecker: false,
		promptURLs: true,
		placeholder: "Bình luận có thể hiển thị với định dạng Markdown.",
		renderingConfig: {
			codeSyntaxHighlighting: true,
		},
	});
}

function ViewComments() {
	var listElements = document.getElementsByName("comment");
	var listComments = new Array();
	listElements.forEach((item) => {
		var cmt = new SimpleMDE({
			element: item,
			toolbar: false,
			status: false,
			spellChecker: false,
			renderingConfig: {
				codeSyntaxHighlighting: true,
			},
		});
		listComments.push(cmt);
	})
	return listComments;
}

function readURL(input, placeToInsertImagePreview) {
	if (input.files) {
		$('.image-upload-wrap').hide();
		$('.file-upload-content').show();
		var filesAmount = input.files.length;
		for (var i = 0; i < filesAmount; i++) {
			var reader = new FileReader();
			reader.onload = (event) => {
				$($.parseHTML('<img width="100">')).attr('src', event.target.result)
					.appendTo(placeToInsertImagePreview);
			}
			reader.readAsDataURL(input.files[i]);
		}
	} else {
		removeUpload();
	}
}

function removeUpload() {
	$('.file-upload-input').replaceWith($('.file-upload-input').clone());
	$('.file-upload-content').hide();
	$('.image-upload-wrap').show();
	$('.preview').replaceWith($.parseHTML('<div class="preview"></div>'));
}