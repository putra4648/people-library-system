import { create } from "zustand";

interface ProfileState {
  open: boolean;
  anchorEl: HTMLElement | null;
  handleClick: (event: React.MouseEvent<HTMLButtonElement>) => void;
  handleClose: VoidFunction;
}

const useProfileStore = create<ProfileState>((set) => ({
  open: false,
  anchorEl: null,
  handleClick: function (event: React.MouseEvent<HTMLButtonElement>) {
    set({
      anchorEl: event.currentTarget,
      open: Boolean(event.currentTarget),
    });
  },
  handleClose: () => set({ open: false, anchorEl: null }),
}));

export default useProfileStore;
