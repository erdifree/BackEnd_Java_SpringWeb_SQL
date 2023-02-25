const CallPhone=({ item }) => {
  return (
    <div>
      <div>{"id chiamata: " + item.id}</div>
      <div>{"Inizio chiamata: " + item.start}</div>
      <div>{"Fine Chiamata: " + item.end}</div>
      <div>{"Costo: " + item.rate}</div>
    </div>
  );
};

export default CallPhone;
