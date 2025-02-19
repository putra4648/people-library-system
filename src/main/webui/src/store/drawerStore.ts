import { create } from "zustand";

interface DrawerState {
  open: boolean;
  toggleDrawer: (newOpen: boolean) => () => void;
}

const useDrawerStore = create<DrawerState>((set) => ({
  open: false,
  toggleDrawer: (newOpen: boolean) => () => {
    set({
      open: newOpen,
    });
  },
}));

export default useDrawerStore;
