document.getElementById("offer").onclick=function(){
            	var data=jQuery('#ta').val();
				var result={
            			"need":data
            	};
            	jQuery.ajax({
            		 url:"check.action",
	       			 type: "post",dataType : "text",
	       			 data:result,
	       			 success: function(json){
	       				 alert("保存成功！");
	       			 }
        })
}