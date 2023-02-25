
let BASE_URL_BREEDS = "http://localhost:8080/api/breeds";

const searchBreeds = async (term) => {
let url = "http://localhost:8080/api/breeds";
  if (term !== null && term !== undefined && term !== "") {
    url += "?keyword=" + term;
  }
  try {
    const response = await fetch(url);
    const data = await response.json();
    //console.log(data);
    return data; // render in base ai dati
  } catch (error) {
    console.log(error);
  }
};


export const putBreeds = async (id,Card) => {
  try {
    const response = await fetch(BASE_URL_BREEDS + "/" + id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(Card),
    });
    const data = await response.json();
    return data;
  } catch (error) {
    console.log(error);
  }
};


export const postBreeds = async (breed) => {
  try {
    const response = await fetch(BASE_URL_BREEDS, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(breed),
    });
    const data = await response.json();
    return data;
  } catch (error) {
    console.log(error);
  }
};



export { searchBreeds };
