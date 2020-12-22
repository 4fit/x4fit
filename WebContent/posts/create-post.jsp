<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tạo bài viết</title>
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png"/>
	
	<!-- GetBootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/highlight.js/latest/styles/github.min.css">
	<script src="https://cdn.jsdelivr.net/highlight.js/latest/highlight.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
	
	<!-- MD Bootstrap CDN -->
	<!-- Bootstrap core CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
	<!-- JQuery -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
</head>
	<style>
		body, html {
			margin: 0;
			padding: 0;
			height: 100%;
			top: 50%;
			left: 50%;
		}
		
		h3 {
			font-size: 2vw;
			text-align: center;
			margin-top: 32px;
			margin-bottom: 24px;
		}
		.CodeMirror {
			height: 300px;
		}

.file-upload {
  background-color: #ffffff;
  width: 600px;
  margin: 0 auto;
  padding: 20px;
}

.file-upload-btn {
  width: 100%;
  margin: 0;
  color: #fff;
  background: #1FB264;
  border: none;
  padding: 10px;
  border-radius: 4px;
  border-bottom: 4px solid #15824B;
  transition: all .2s ease;
  outline: none;
  text-transform: uppercase;
  font-weight: 700;
}

.file-upload-btn:hover {
  background: #1AA059;
  color: #ffffff;
  transition: all .2s ease;
  cursor: pointer;
}

.file-upload-btn:active {
  border: 0;
  transition: all .2s ease;
}

.file-upload-content {
  display: none;
  text-align: center;
}

.file-upload-input {
  position: absolute;
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  outline: none;
  opacity: 0;
  cursor: pointer;
}

.image-upload-wrap {
  margin-top: 20px;
  border: 4px dashed #1FB264;
  position: relative;
}

.image-dropping,
.image-upload-wrap:hover {
  background-color: #1FB264;
  border: 4px dashed #ffffff;
}

.image-title-wrap {
  padding: 0 15px 15px 15px;
  color: #222;
}

.drag-text {
  text-align: center;
}

.drag-text h3 {
  font-weight: 100;
  text-transform: uppercase;
  color: #15824B;
  padding: 60px 0;
}

.file-upload-image {
  max-height: 200px;
  max-width: 200px;
  margin: auto;
  padding: 20px;
}

.remove-image {
  width: 200px;
  margin: 0;
  color: #fff;
  background: #cd4535;
  border: none;
  padding: 10px;
  border-radius: 4px;
  border-bottom: 4px solid #b02818;
  transition: all .2s ease;
  outline: none;
  text-transform: uppercase;
  font-weight: 100;
}

.remove-image:hover {
  background: #c13b2a;
  color: #ffffff;
  transition: all .2s ease;
  cursor: pointer;
}

.remove-image:active {
  border: 0;
  transition: all .2s ease;
}
	</style>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand logo" href="${pageContext.request.contextPath}/">X4FIT</a>
	  <a class="navbar-brand" href="${pageContext.request.contextPath}/about.jsp">ABOUT</a>
  </nav>
  <div class="container">
  	<h3 align="center">TẠO BÀI VIẾT</h3>
		<form action="${pageContext.request.contextPath}/CreatePost" method="post">
			<div class="form-group">
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="basic-addon1">Tiêu đề</span>
				  </div>
				  <input type="text" class="form-control" placeholder="Tiêu đề bài viết" name="title">
				</div>
				<div>
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1">Tags</span>
					  </div>
					  <input type="text" class="form-control" placeholder="Chủ đề bài viết" name="tags">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1">Thumbnail</span>
					  </div>
					  <div class="custom-file">
					  	<label class="custom-file-label" for="customFileLang"></label>
						  <input type="file" class="custom-file-input" id="customFileLang" lang="vi">
						</div>
					</div>
				</div>
				<textarea name="content" id="content"></textarea>
				<input class="btn btn-primary btn-sm btn-block" type="submit" value="Post">
			</div>
		</form>
	</div>
	<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
		<div class="file-upload">
		  <div class="image-upload-wrap">
		    <input class="file-upload-input" type='file' name="file" onchange="readURL(this, 'div.preview');" accept="image/*" multiple="true"/>
		    <div class="drag-text">
		      <h3>Drag and drop a file or select add Image</h3>
		    </div>
		  </div>
		  <div class="file-upload-content">
		  	<div class="preview"></div>
		    <div class="image-title-wrap">
		      <button type="button" onclick="removeUpload()" class="remove-image">Remove ALL</button>
		    </div>
		  </div>
		  <div align="center">
		  	<input type="submit" value="Upload"/>
		  </div>
		</div>
	</form>
	<hr>
	<script type="text/javascript">
		function readURL(input, placeToInsertImagePreview) {
			if (input.files) {
				$('.image-upload-wrap').hide();
				$('.file-upload-content').show();
				var filesAmount = input.files.length;
				for (i = 0; i < filesAmount; i++)
				{
            var reader = new FileReader();
            reader.onload = function(event)
            {
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
		$('.image-upload-wrap').bind('dragover', function () {
			$('.image-upload-wrap').addClass('image-dropping');
		});
		$('.image-upload-wrap').bind('dragleave', function () {
			$('.image-upload-wrap').removeClass('image-dropping');
		});
	</script>
	<script type="text/javascript">
		$('.file-upload').file_upload();
	</script>
	<script type="text/javascript">
  const simplemde = new SimpleMDE({
		element: document.getElementById("content"),
		toolbar: ["bold", "italic", "strikethrough", "|",
							"heading-1", "heading-2", "heading-3","|",
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
  
  </script>
</body>
</html>