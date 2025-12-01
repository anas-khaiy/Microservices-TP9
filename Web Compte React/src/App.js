import React from 'react';
import CompteList from './components/CompteList';
import CompteForm from './components/CompteForm';

function App() {
  const [refreshKey, setRefreshKey] = React.useState(0);

  const handleAccountAdded = () => {
    setRefreshKey(oldKey => oldKey + 1);
  };

  return (
    <div>
      <CompteForm onAccountAdded={handleAccountAdded} />
      <CompteList key={refreshKey} />
    </div>
  );
}

export default App;