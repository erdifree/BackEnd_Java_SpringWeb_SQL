
import { useState } from "react";


export const FormBreeds = ({ callWhenSubmit }) => {
  const [minlife, setMinlife] = useState(1);
  const [maxlife, setMaxlife] = useState(1);
  const [breed, setBreed] = useState({
    name: "",
    description: "",
    imageUrl: "",
    trainability: 1,
    minLifeSpan: 1,
    maxLifeSpan: 1,

    size: "",
  });

  const handleInputChange = (event) => {
    setBreed({ ...breed, [event.target.name]: event.target.value });
    console.log(breed);
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();
 console.log("SearchBar dice " + JSON.stringify(breed));
     callWhenSubmit(JSON.stringify(breed));
  };

  // This function is called when the first range slider changes
  const changeMinlife = (event) => {
    setMinlife(event.target.value);
    handleInputChange(event);
    console.log(minlife);
  };
  const changeMaxlife = (event) => {
    setMaxlife(event.target.value);
    handleInputChange(event);
    console.log(maxlife);
  };
  return (
    <form onSubmit={handleFormSubmit}>
      <label htmlFor="name" className="form-label">
        Name
      </label>
      <input type="text" name="name" onChange={handleInputChange} />
      <label htmlFor="description" className="form-label">
        Description
      </label>
      <textarea
        name="description"
        className="form-control"
        cols="5"
        rows="5"
        maxLength="250"
        onChange={handleInputChange}
      ></textarea>
      <label htmlFor="imageUrl" className="form-label">
        Image Url
      </label>
      <input
        type="url"
        name="imageUrl"
        onChange={handleInputChange}
        className="form-control"
      />
      <label htmlFor="trainability" className="form-label">
        Trainability
      </label>
      <select name="trainability" onChange={handleInputChange}>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select>
      <br />
      <label htmlFor="minLifeSpan" className="form-label">
        Minimum life span
      </label>
      <input
        type="range"
        onChange={changeMinlife}
        step={1}
        min={1}
        max={25}
        name="minLifeSpan"
        value={minlife}
        className="form-control"
      />
      <output>{minlife}</output> <br />
      <label htmlFor="maxLifeSpan" className="custom-slider">
        Maximum life span
      </label>
      <input
        type="range"
        onChange={changeMaxlife}
        step={1}
        min={1}
        max={25}
        value={maxlife}
        name="maxLifeSpan"
        className="form-control"
      />
      <output>{maxlife}</output> <br />
      <label htmlFor="size" className="form-label">
        Size
      </label>
      <select name="size" onChange={handleInputChange}>
        <option value="X-SMALL">x-small</option>
        <option value="SMALL">small</option>
        <option value="MEDIUM">medium</option>
        <option value="LARGE">large</option>
        <option value="X-LARGE">x-large</option>
      </select>
      <button type="submit" className="btn btn-primary">
        Send
      </button>
    </form>
  );
};


