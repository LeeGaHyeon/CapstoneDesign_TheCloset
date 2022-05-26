async function model() {
    const model = await tf.loadLayersModel('https://github.com/LeeGaHyeon/CapstoneDesign_TheCloset/blob/main/tensorflow%20js/model.json');
    console.log("succces");
    const imgElement = document.getElementById("imagele");
    const prediction = await model.predict(imgElement);
    console.log(prediction);
}
// JavaScript


