import { useState, useEffect } from "react";
import { findesubbyid, searchSub } from "./Api";
import { SubscriberList } from "./components/SubscriberList";
import { SearchBar } from "./components/SearchBar";
import React, { Fragment } from "react";

const App = () => {
  const [data, setData] = useState([]);

  const updateData = async (key) => {
    const responseData = await searchSub(key);
    setData(responseData);
  };

  const handleSeachBarSubmit = async (key) => {
    updateData(key);
  };

  useEffect(() => {
    updateData();
  }, []);

  const deleteSubscriber=async(id)=>{
  const responseData = await findesubbyid(id);
   setData(responseData);
   updateData();
  }
  return (
    <Fragment>
      <div className="container text-center bg-body-tertiary">
        <h1>Call Center</h1>
        <SearchBar callWhenSubmit={handleSeachBarSubmit} />
        <SubscriberList data={data} onDelete={deleteSubscriber}/>
      </div>
    </Fragment>
  );
};
export default App;
