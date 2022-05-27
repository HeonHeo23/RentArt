function showPopUp(url) {
  let width = 1000;
  let height = 650;
  let left = (window.screen.width / 2) - (width / 2);
  let top = (window.screen.height / 4);
  
  let windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';
	
  window.open(url, "글쓰기", windowStatus);
}