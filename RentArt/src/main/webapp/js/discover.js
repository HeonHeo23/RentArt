function checkP(ft, fp, fs) {
  ft.forEach((i) => checkF("filter-theme-"+i));
  fs.forEach((i) => checkF("filter-size-"+i));
  fp.forEach((i) => checkF("filter-price-"+i));
}
function checkF(p) {
  document.getElementById(p).checked = true;
}