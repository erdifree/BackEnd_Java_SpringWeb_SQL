import React from "react";
import ReactDOM from "react-dom";
import Modal from "react-modal";
import { useState } from "react";

const customStyles = {
  content: {
    top: "50%",
    left: "50%",
    right: "auto",
    bottom: "auto",
    marginRight: "-50%",
    transform: "translate(-50%, -50%)",
  },
};

// Make sure to bind modal to your appElement (https://reactcommunity.org/react-modal/accessibility/)
Modal.setAppElement("#root");

const ModalPutBreeds = ({ callWhenSubmit }) => {
  let subtitle;
  const [modalIsOpen, setIsOpen] = React.useState(false);
  const [minlife, setMinlife] = useState(1);
  const [maxlife, setMaxlife] = useState(1);

  const [inputValue, setInputValue] = useState({
    name: "",
    description: "",
    imageUrl: "",
    trainability: 1,
    minLifeSpan:{minlife},
    maxLifeSpan: {maxlife},

    size: "",
  });

  const handleInputChange = (event) => {
    setInputValue({[event.target.name]:event.target.value});
  // console.log(inputValue);
  };


  const handleFormSubmit = (event) => {
    event.preventDefault();
    console.log("SearchBar dice " + inputValue);
  // callWhenSubmit(inputValue);
  };

  function openModal() {
    setIsOpen(true);
  }

  function afterOpenModal() {
    // references are now sync'd and can be accessed.
    subtitle.style.color = "#f00";
  }

  function closeModal() {
    setIsOpen(false);
  }

  // This function is called when the first range slider changes
  const changeMinlife = (event) => {
    setMinlife(event.target.value);
    handleInputChange(event);
    console.log(minlife);
    
  };
  const changeMaxlife = (event) => {
    setMaxlife(event.target.value);
    console.log(maxlife);
  };

  return (
    <div>
      <button onClick={openModal}>Open Modal</button>
      <Modal
        isOpen={modalIsOpen}
        onAfterOpen={afterOpenModal}
        onRequestClose={closeModal}
        style={customStyles}
        contentLabel="Example Modal"
      >
        <h2 ref={(_subtitle) => (subtitle = _subtitle)}>Hello</h2>
        <button onClick={closeModal}>close</button>
        <div>I am a modal</div>

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
          <label htmlFor="imageurl" className="form-label">
            Image Url
          </label>
          <input
            type="url"
            name="imageurl"
            onChange={handleInputChange}
            className="form-control"
          />
          <label htmlFor="train" className="form-label">
            Trainability
          </label>
          <select name="train" onChange={handleInputChange}>
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
          <select name="size" id="size">
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
      </Modal>
    </div>
  );
};

export { ModalPutBreeds };
