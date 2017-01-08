

function(doc) {
  emit(doc._id, doc.lname+" "+doc.fname);
}
